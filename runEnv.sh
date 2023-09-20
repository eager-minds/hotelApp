#!/bin/bash

bar_size=40
bar_char_done="#"
bar_char_todo="-"
bar_percentage_scale=0

function show_progress {
    current="$1"
    total="$2"
    message="${3:-Progress}"

    # calculate the progress in percentage
    percent=$(bc <<< "scale=$bar_percentage_scale; 100 * $current / $total" )
    # The number of done and todo characters
    done=$(bc <<< "scale=0; $bar_size * $percent / 100" )
    todo=$(bc <<< "scale=0; $bar_size - $done" )

    # build the done and todo sub-bars
    done_sub_bar=$(printf "%${done}s" | tr " " "${bar_char_done}")
    todo_sub_bar=$(printf "%${todo}s" | tr " " "${bar_char_todo}")

    # output the bar
    echo -ne "\r$message : [${done_sub_bar}${todo_sub_bar}] ${percent}%"
}

docker network create eagerminds_hotel
docker-compose -f ./composes/docker-compose-kafka.yml -p kafka-stack up -d
docker-compose -f ./composes/docker-compose-mongodb.yml -p mongodb-stack up -d



#for number in $(seq ${_start} ${_end}); do
#  sleep 0.1
#  show_progress ${number} ${_end} "Waiting for schema registry"
#done

defaultRetries=10
#retries=$defaultRetries
_start=1
_end=100
cont=$_start
retries=$_end
while [ $cont -le $retries ]; do
  if [ $cont -gt 0 ]; then

    show_progress $cont $retries "Waiting for schema registry"
#    echo "Waiting for schema-registry... retry: $cont/$retries"
  fi
  schemaRegistryStatus=$(curl --write-out '%{http_code}' --silent --output /dev/null localhost:8081)
  if [[ "$schemaRegistryStatus" -eq 200 ]]; then
    show_progress $retries $retries "Waiting for schema registry"
    echo
    echo "Schema-registry is running!"
    ./registry.sh
    break
  fi
  sleep 0.15
  ((cont++))

  if [ "$cont" -gt $retries ]; then
    PS3='Schema-registry is not running, try Again?'
    options=("Yes" "No")
    select opt in "${options[@]}"; do
      case $opt in
      "Yes")
        retries=$((retries + _end))
        break
        ;;
      "No")
        break
        ;;
      *) echo "invalid option $REPLY" ;;
      esac
    done
    echo
  fi
done

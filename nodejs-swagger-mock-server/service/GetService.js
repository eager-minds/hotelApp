'use strict';

/**
 * Retrieve availability search and count of similar searches
 * By passing a searchId, you can retrieve count of similar searches.
 *
 * searchId UUID pass an optional search string for looking up inventory
 * returns SearchCountItem
 **/
exports.retrieveSearch = function (searchId) {
  return new Promise(function (resolve, reject) {
    var examples = {};
    examples['application/json'] = {
      "search": {
        "checkIn": "29-12-2023",
        "ages": [30, 29, 1, 3],
        "hotelId": "1234aBc",
        "checkOut": "31-12-2023"
      },
      "searchId": "d290f1ee-6c54-4b01-90e6-d701748f0851",
      "count": 100
    };
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


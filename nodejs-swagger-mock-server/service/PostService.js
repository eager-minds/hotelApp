'use strict';

/**
 * Save new availability search
 * Save a new availability search
 *
 * body SearchItem Search item to add (optional)
 * returns inline_response_201
 **/
exports.createSearch = function (body) {
  return new Promise(function (resolve, reject) {
    var examples = {};
    examples['application/json'] = {
      "searchId": "046b6c7f-0b8a-43b9-b35d-6489e6daee91"
    };
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


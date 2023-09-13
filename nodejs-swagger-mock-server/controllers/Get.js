'use strict';

var utils = require('../utils/writer.js');
var Get = require('../service/GetService');

module.exports.retrieveSearch = function retrieveSearch (req, res, next, searchId) {
  Get.retrieveSearch(searchId)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

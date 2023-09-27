'use strict';

var utils = require('../utils/writer.js');
var Post = require('../service/PostService');

module.exports.createSearch = function createSearch(req, res, next, body) {
  Post.createSearch(body)
  .then(function (response) {
    utils.writeJson(res, response);
  })
  .catch(function (response) {
    utils.writeJson(res, response);
  });
};

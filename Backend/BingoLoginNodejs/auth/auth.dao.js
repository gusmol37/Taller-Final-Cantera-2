/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

const mongoose = require('mongoose');
const authSchema = require('./auth.model');

authSchema.statics = {
  create: function (data, cb) {
    const user = new this(data);
    user.save(cb);
  },
  login: function (query, cb) {
    this.find(query, cb);
  }
}

const authModel = mongoose.model('Users', authSchema);
module.exports = authModel;
/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

const Users = require('./auth.controller');
module.exports = (router) => {
  router.post('/signin', Users.createUser);
  router.post('/login', Users.loginUser);
}

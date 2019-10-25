const { Pool } = require('pg');
const config = require('./dbconfig.js');

const connection = new Pool(config);

module.exports = connection;

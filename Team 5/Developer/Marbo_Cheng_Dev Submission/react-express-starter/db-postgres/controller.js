const connection = require('./connection.js');


/* GET top popular tags */
/*
SELECT views,tags, likes FROM youtube WHERE tags LIKE '%trump%' 
ORDER BY views,likes DESC LIMIT 10;
*/

/*Get all data */
const getAllTags = () => {
 
  const query = `SELECT tags,views,likes FROM youtube ORDER BY views DESC LIMIT 10`;
  console.log(query);
  return new Promise((resolve, reject) => {
    connection.query(query, (err, res) => {
      if (err) {
        console.log(err);
        return reject(err);
      }
      resolve(res.rows);
    });
  });
};

/*Allows user to search term and show top 10  */
const searchTag = (term) => {
  const query = `SELECT views,tags, likes FROM youtube WHERE tags LIKE '%${term}%' ORDER BY views,likes DESC LIMIT 10`;
  console.log(query);
  return new Promise((resolve, reject) => {
    connection.query(query, (err, res) => {
      if (err) {
        console.log(err);
        return reject(err);
      }
      console.log(res);
      resolve(res);
    });
  });
};



module.exports = {
  getAllTags,
  searchTag,

};

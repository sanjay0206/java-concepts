# MongoDB Movie Database Learning Guide


## MongoDB Definition

MongoDB is a NoSQL database that stores data in flexible, JSON-like documents. Unlike traditional relational databases that store data in rows and columns, MongoDB is document-oriented, making it ideal for handling large, unstructured, and semi-structured data.

## Advantages of MongoDB over SQL Databases

1. **Flexible Schema**: MongoDB allows a flexible schema design, meaning fields can vary from document to document. SQL databases require predefined schemas with structured tables and rows.

2. **Scalability**: MongoDB offers horizontal scalability through sharding, distributing data across multiple machines. SQL databases usually scale vertically by increasing hardware resources.

3. **High Performance for Large Data**: MongoDB is optimized for read/write performance with large datasets, making it ideal for big data applications.

4. **Rich Query Language**: MongoDB supports complex queries, indexing, aggregation, and geospatial data, providing more functionality than simple key-value NoSQL stores.

5. **Replication and High Availability**: MongoDB supports automatic replication with replica sets, which ensures data redundancy and high availability.

6. **Integration with Big Data Technologies**: MongoDB is well integrated with modern big data technologies like Hadoop, Spark, etc., making it a good choice for big data applications.

## MongoDB vs SQL Databases Comparison

| Feature                     | MongoDB                                       | SQL Databases (e.g., MySQL, PostgreSQL)       |
|------------------------------|-----------------------------------------------|-----------------------------------------------|
| Data Model                   | Document-oriented (JSON-like BSON)            | Table-based (rows and columns)                |
| Schema                       | Dynamic (schema-less)                         | Rigid (schema-bound with predefined structure)|
| Query Language                | MongoDB Query Language (MQL)                  | SQL                                           |
| Transactions                  | Supports multi-document transactions          | Supports ACID transactions                     |
| Scalability                   | Horizontally scalable with sharding           | Mostly vertically scalable                     |
| Performance                   | Optimized for high-volume data and write-heavy operations | Suitable for structured data and read-heavy operations |
| Replication                   | Built-in replication (Replica sets)           | Varies (master-slave, master-master)           |
| Use Case                      | Big data, real-time applications, IoT, content management | Structured data, financial apps, OLTP          |

---

## 1. Database Creation & Usage
### Create and Use Database
Use the `use` command to create or switch to a specific database:

```bash
use movieDB
```
If the database doesn't exist, MongoDB will create it when you first insert data.

### Drop Database
```bash
db.dropDatabase() 
```

## 2. Collection Creation & Dropping
### Create Collection
Collections in MongoDB are created automatically when you insert documents. But, if you want to create one explicitly:

```bash
db.createCollection("movies")
```

### Drop Collection
Remove a collection and its data:

```bash
db.movies.drop()
```

---

## 3. Insert Documents
### Insert One
To insert a single document into a collection:

```bash
db.movies.insertOne({
  title: "Inception",
  director: "Christopher Nolan",
  release_date: new Date("2010-07-16"),
  genres: ["Sci-Fi", "Thriller"],
  rating: 8.8,
  boxoffice: 829895144
})
```

### Insert Many
Insert multiple documents at once:

```bash
db.movies.insertMany([
  { title: "The Matrix", director: "Wachowskis", release_date: new Date("1999-03-31"), genres: ["Sci-Fi"], rating: 8.7 }, boxoffice: 463517383,
  { title: "Interstellar", director: "Christopher Nolan", release_date: new Date("2014-11-07"), genres: ["Sci-Fi", "Drama"], rating: 8.6 }, boxoffice: 677471339,
  { title: "The Upside", director: "Neil Burger", release_date: new Date("2019-01-11"), genres: ["Comedy", "Drama"], rating: 6.9, boxOffice: 107187120}
])
```

---

## 4. Querying Data
### Find Documents
Retrieve all documents in the collection:

```bash
db.movies.find()
```

### Find One
Retrieve the first document that matches the query:

```bash
db.movies.findOne()
```

### Other types

```bash
# 1. Basic Find: Retrieves all documents.
db.movies.find({ director: "Christopher Nolan" })

# 2. Equality: Matches documents where the director is "Christopher Nolan".
db.movies.find({ director: { $eq: "Christopher Nolan" } })

# 3. Comparison: Finds documents with rating > 8.0.
db.movies.find({ rating: { $gt: 8.0 } })

# 4. Logical: Matches documents with either director or rating > 8.5.
db.movies.find({ $or: [{ director: "Christopher Nolan" }, { rating: { $gt: 8.5 } }] })

# 5. Regex: Finds titles containing "batman", case-insensitive.
db.movies.find({ title: { $regex: /batman/i } }) 

# 6. Projection: Retrieves only title and director fields.
db.movies.find({}, { title: 1, director: 1 }) 

# 7. Sorting: Retrieves documents sorted by rating (desc).
db.movies.find().sort({ rating: -1 })  

# 8. Limit: Retrieves the first 5 documents.
db.movies.find().limit(5)  

# 9. Skip: Skips the first 10 documents.
db.movies.find().skip(10) 

# 10. Aggregation: Groups by director and averages ratings > 8.0.
db.movies.aggregate([
  { $match: { rating: { $gt: 8.0 } } },
  { $group: { _id: "$director", averageRating: { $avg: "$rating" } } }
])

# 11. Text Search: Finds documents containing "Inception".
db.movies.find({ $text: { $search: "Inception" } })
```

### Counting Documents

Count the number of movies in the collection.

```bash
db.movies.countDocuments()
```

### Distinct Documents

To identify unique values of a specified field across all documents in a collection.

```bash
db.movies.distinct("director")
```
---

## 5. Updating Documents
### Update One (Upsert)
Update the first document that matches the query:

```bash
db.movies.updateOne(
  { title: "Inception" },
  { $set: { rating: 9.0 } }
)
```

### FindOneAndUpdate
Finds the first document that matches the query and updates it in one atomic operation. It can optionally return the updated document.

```bash
db.movies.findOneAndUpdate(
  { title: "Inception" },
  { $set: { rating: 9.1 } },
  { returnNewDocument: true }
)
```

### Replace a Document
Replaces an entire document based on the query condition.

```bash
db.movies.replaceOne(
  { title: "The Matrix" },
  {
    title: "The Matrix Reloaded",
    director: "Lana Wachowski, Lilly Wachowski",
    release_date: new Date("2003-05-15"),
    genres: ["Sci-Fi", "Action"],
    rating: 7.2
  }
)
```

### Update Many
Update multiple documents at once:

```bash
db.movies.updateMany(
  { genres: "Sci-Fi" },
  { $set: { rating: 9.0 } }
)
```

---

## 6. Deleting Documents
### Delete One
Delete a single document that matches the query:

```bash
db.movies.deleteOne({ title: "Inception" })
```

### findOneAndDelete
Finds the first document that matches the query and deletes it, returning the deleted document.

```bash
db.movies.findOneAndDelete({ title: "Inception" })
```

### Delete Many
Delete multiple documents that match the query:

```bash
db.movies.deleteMany({ genres: "Sci-Fi" })
```

---

## 7. Find & Update in One Step
Use `findOneAndUpdate` to find a document and update it in one operation:

```bash
db.movies.findOneAndUpdate(
  { title: "Inception" },
  { $set: { rating: 9.1 } },
  { returnNewDocument: true }
)
```

---

## 8. Operators (Comparison, Logical, etc.)
### Comparison Operators
| **Operator** | **Description**                                                | **Example Usage**                                                                 |
|--------------|----------------------------------------------------------------|-----------------------------------------------------------------------------------|
| `$eq`        | Matches documents where the field is equal to a value           | `db.movies.find({ rating: { $eq: 8.8 } })`                                        |
| `$ne`        | Matches documents where the field is not equal to a value       | `db.movies.find({ rating: { $ne: 8.8 } })`                                        |
| `$gt`        | Matches documents where the field is greater than a value       | `db.movies.find({ rating: { $gt: 7.5 } })`                                        |
| `$gte`       | Matches documents where the field is greater than or equal to   | `db.movies.find({ rating: { $gte: 7.5 } })`                                       |
| `$lt`        | Matches documents where the field is less than a value          | `db.movies.find({ rating: { $lt: 7.5 } })`                                        |
| `$lte`       | Matches documents where the field is less than or equal to      | `db.movies.find({ rating: { $lte: 7.5 } })`                                       |
| `$in`        | Matches documents where the field's value is in an array        | `db.movies.find({ rating: { $in: [ 8.0, 8.5 ] } })`                               |
| `$nin`       | Matches documents where the field's value is not in an array    | `db.movies.find({ rating: { $nin: [ 8.0, 8.5 ] } })`                              |

### Logical Operators
| Operator     | Description                                                | Example Usage                                                                 |
|--------------|------------------------------------------------------------|-------------------------------------------------------------------------------|
| `$and`       | Joins query clauses with a logical AND                     | `db.movies.find({ $and: [ { release_date: { $gt: new Date("2000-01-01") } }, { rating: { $gt: 8 } } ] })` |
| `$or`        | Joins query clauses with a logical OR                      | `db.movies.find({ $or: [ { release_date: new Date("1958-01-01") }, { release_date: new Date("1959-01-01") } ] })` |
| `$not`       | Inverts the effect of a query expression                   | `db.movies.find({ title: { $not: { $eq: "Inception" } } })`                     |
| `$nor`       | Joins query clauses with a logical NOR                     | `db.movies.find({ $nor: [ { boxoffice: 1.99 }, { rating: 9 } ] })`              |

## Text search Operators in MongoDB

| Operator  | Description                                               | Example Usage                                                    |
|-----------|-----------------------------------------------------------|------------------------------------------------------------------|
| `$text`   | Performs text search on the indexed fields of the collection. | `db.movies.find({ $text: { $search: "Nolan" } })` |

## Array Operators in MongoDB

| Operator     | Description                                                | Example Usage                                               |
|--------------|------------------------------------------------------------|-------------------------------------------------------------|
| `$elemMatch` | Matches documents that contain an array field with at least one element matching the specified query | `db.movies.find({ genres: { $elemMatch: { $eq: "Comedy" }}, rating: { $gt: 6 }})` |
| `$all`       | Matches arrays that contain all elements specified in the query. | `db.movies.find({ genres: { $all: ["Drama", "Comedy"] } })` |

## Element Operators in MongoDB

| Operator     | Description                                                | Example Usage                                                                 |
|--------------|------------------------------------------------------------|-------------------------------------------------------------------------------|
| `$exists`    | Matches documents where the field exists or not            | `db.movies.find({ director: { $exists: true } })`                               |
| `$type`      | Matches documents with specified BSON data type            | `db.movies.find({ "boxoffice": { $type: "number" } })`                          |


---

## 9. Text Search
### Create a Text Index
To perform text searches, you need a text index on the field you want to search:

```bash
db.movies.createIndex({ director: "text" })
```

### Text Search Query
Use `$text` to search for a term in the indexed fields:

```bash
db.movies.find(
  { $text: { $search: "Nolan" } },
  { score: { $meta: "textScore" } }
).sort(
  { score: { $meta: "textScore" } }
)
```

---

## 10. Aggregation Pipeline
Use aggregation pipelines to process and transform documents:

Calculate the total box office for all "Sci-Fi" movies.

```bash
db.movies.aggregate([ 
  { $match: { genres: "Sci-Fi" } }, 
  { $group: { _id: "$genres", totalBoxOffice: { $sum: "$boxoffice" } } }
])
```

Calculate the average rating of all "Sci-Fi" movies and sort the result by average rating in descending.

```bash
db.movies.aggregate([
  { $match: { genres: "Sci-Fi" } },
  { $group: { _id: "$director", avgRating: { $avg: "$rating" } } },
  { $sort: { avgRating: -1 } }
])
```
---

## 11. Projections
To include or exclude fields in the result: 1-include, 0-exclude

Fetches all documents
```bash
db.movies.find(
  {},
  { title: 1, director: 1, _id: 0 }
)
```

Fetches documents with only genres of `Sci-Fi`
```bash
db.movies.find(
  { genres: "Sci-Fi" },
  { title: 1, director: 1, _id: 0 }
)
```

---

## 12. Sorting, Skip, and Limit
### Sort Results
Sort the results by a specific field:

```bash
db.movies.find().sort({ rating: -1 })  # Sort by rating in descending order
```

### Skip and Limit
Control the number of results returned:

```bash
db.movies.find().skip(2).limit(3)  # Skip the first 2 and return the next 3
```

---

## 12. Regex
### Basic Matching
Matches documents with "Inception" in the title.

```bash
db.movies.find({ title: { $regex: "Inception" } })  
```

### Case Insensitivity
To make the regex case-insensitive, use the `i` option. Matches "Inception", "inception", "INCEPTION", etc.

```bash
db.movies.find({ title: { $regex: /inception/i } })  
```

### Anchors
Anchors are used to specify positions in the string.
* ^ : Start of a string.
* $ : End of a string.

```bash
# Matches titles starting with "Inception".
db.movies.find({ title: { $regex: /^Inception/ } }) 

# Matches titles ending with "Nolan".
db.movies.find({ title: { $regex: /Nolan$/ } }) 
```
---

## 13. Index Management
### Create Index
Create an index on a specific field:

```bash
 db.movies.createIndex({ title: 1 })
```

### Get Index

```bash
db.movies.getIndexes()
db.movies.getIndexKeys()
```

### Drop Index
Remove an index:

```bash
db.movies.dropIndex({ title: 1 })
```

### Hide/Unhide Index
Temporarily disable an index:

```bash
db.movies.hideIndex("title_1")
```

Unhide the index later:

```bash
db.movies.unhideIndex("title_1")
```

---

## 14. What is Sharding in MongoDB?
Sharding is a method used in MongoDB to distribute data across multiple servers, or shards. This allows a database to scale horizontally by adding more servers to handle large datasets and high throughput operations. Each shard is a subset of the data, and together, they form a complete dataset.

### Key Features of Sharding:
- **Horizontal Scalability**: Sharding allows you to add more servers to handle increased loads, rather than simply upgrading existing hardware (vertical scaling).
- **Data Distribution**: Data is divided into chunks, and each chunk is distributed across shards. This distribution is based on a shard key, which determines how data is split.
- **Automatic Balancing**: MongoDB automatically balances the data across shards as data grows, redistributing chunks to ensure even load distribution.
- **High Availability**: Shards can be replicated, which means if one shard fails, others can continue to serve requests, ensuring system reliability.

### Example of Sharding with a Movie Database
Let's say we have a movie database where we store documents about movies, and we expect the number of movies to grow significantly over time. Here's how sharding would work:

1. **Define a Shard Key**: Choose a field that will distribute the documents evenly across shards. In this case, we might choose `release_year` as the shard key.
2. **Create a Sharded Cluster**: Set up a sharded cluster that consists of multiple shards. For instance, we could have three shards:
   - Shard 1: Contains movies released from 1900 to 1950.
   - Shard 2: Contains movies released from 1951 to 2000.
   - Shard 3: Contains movies released from 2001 onward.
3. **Distributing Data**: As movies are added to the database, they will automatically be routed to the appropriate shard based on their `release_year`.
4. **Querying**: When querying for movies, MongoDB will direct the query to the relevant shard(s). For example:

```javascript
db.movies.find({ release_year: { $gte: 1990 } })  // Query for movies released in or after 1990
```
This query would only access Shard 2 and Shard 3, improving performance by reducing the amount of data that needs to be scanned.

### How Sharding Works:
- **Shards**: Store data, each shard is a replica set for redundancy.
- **Query Routers**: Route queries to the correct shard.
- **Config Servers**: Store metadata and configuration of the sharded cluster.

A **shard key** is used to determine how data is distributed across the shards. It must be chosen carefully for optimal performance.

---

## Example of Sharding in MongoDB (Using `release_year` as the Shard Key)

### Step 1: Enable Sharding on the Database
```javascript
sh.enableSharding("movieDB")
```

### Step 2: Create an Index on the Shard Key
```javascript
db.movies.createIndex({ release_year: 1 })
```

### Step 3: Shard the Collection
```javascript
sh.shardCollection("movieDB.movies", { release_year: 1 })
```

### Example Query on Sharded Collection:
```javascript
db.movies.find({ release_year: { $gt: 2015 } })
```

---

### MongoDB Sharding Example with `release_year`

```json
{
   "_id": ObjectId("66fc467c63b9531ab7cb64ec"),
   "title": "The Upside",
   "director": "Neil Burger",
   "release_date": ISODate("2019-01-10T18:30:00.000Z"),
   "release_year": 2019,
   "genres": ["Drama", "Comedy"],
   "rating": 6.9,
   "boxoffice": Long("107187120"),
   "_class": "com.spring.mongo.entity.Movie"
}
```
In this case, `release_year` is used as the shard key, distributing documents across shards based on the year the movie was released.

---

## 15. Read & Write Concern
### Read Concern
Set the read consistency level:

```bash
db.movies.find().readConcern("majority")
```

### Write Concern
Set the write acknowledgment level:

```bash
db.movies.insertOne(
  { title: "Dune", director: "Denis Villeneuve" },
  { writeConcern: { w: "majority", wtimeout: 5000 } }
)
```
---

## 15. Transactions
Transactions allow you to execute multiple operations atomically, meaning either all operations succeed, or none are applied.

### Start Transaction
Start a transaction to perform multiple operations atomically.

```bash
session = db.getMongo().startSession()
session.startTransaction()
```

### Commit Transaction
Commit the transaction after performing the necessary operations.

```bash
session.commitTransaction()
session.endSession()
```

### Abort Transaction
Abort the transaction if necessary.

```bash
session.abortTransaction()
session.endSession()
```

## Example Workflow:
1) Start a session and transaction.
2) Perform operations (e.g., insert or update).
3) Either commit or abort the transaction based on the result.
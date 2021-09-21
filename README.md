# backend coding challenge solution guideLine

## End point url:
Get Request:
http://localhost:8080/api/trending/github/repos

## Returned List
The returned list contains some objects, each of them will have:
- Language name
- Number of repos use this language
- Array of the repos that use this language (repo object contains all information returned by github api) 

## Notes

- Some repos have no specified language, so that you will find a language called "No Language Specified" which will have the number of repos which has no language specified and all information about these repos
- The returned List is sorted descending by the number of repos use the language
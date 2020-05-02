# Core Concepts

## Resources

Everything in Lepton is a Resource.

### Schema

|       	| Column       	| Type     	|
|-------:	|--------------	|----------	|
| PK    	| id           	| number   	|
| FK    	| directory_id 	| number   	|
| Index 	| uri          	| string   	|
|       	| data         	| JSONData 	|

## Directories (aka: Types)

Directories categorise Resources. They are also referred
to as Types.

Directories can be ordered hierarchically.

The `path` is the name of the directory. For

When defining a new type, its

Root
directories

### Schema

|    	    | Column    	| Type     	|
|----:	    |-----------	|----------	|
| PK 	    | id        	| number   	|
| FK (self) | parent_id 	| number   	|
|           | path          | string    |
| unique    | fullpath      | string    |
|    	    | schema    	| JSONData 	|


## Links

Links are relationships between two Resources of any time.

### Schema

TD

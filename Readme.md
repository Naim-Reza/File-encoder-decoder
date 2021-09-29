# File Encoder-Decoder

### Command
````shell
java FileED [option: encode | decode] <source-file> <destination> [encoding-method: base64 | character]
````
__Encoding Command__
```shell
java FileED encode <source-file> <destination> [encoding-method: base64 | character]
```
__Decoding Command__
```shell
java FileED decode <source-file>
```


use this command to encode or decode a file.

### Parameters

__option__ : values: encode, decode. 

Determines what to do with the provided file.

__source-file__ : The file that needs to be encoded or decoded. File must be provided with extension.

__destination__ : The output file name. Does not need to provide extension.

__encoding-method__: values: base64, character

provides the type of encoding that can be applied.


### Example
* To encode a file named cat.jpg use the following command

```shell
java FileED encode cat.jpg cat_out base64
```

* To decode a file named cat_out.txt use the following command

```shell
java FileED decode cat_out.txt
```
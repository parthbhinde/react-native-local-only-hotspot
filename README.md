# react-native-local-only-hotspot
This is a react native module to start a local-only hotspot on android devices running android 8 and above
## Getting started

`$ npm install react-native-local-only-hotspot --save`

## Usage
```javascript
import LocalOnlyHotspot from 'react-native-local-only-hotspot';

// To start the local-only-hotspot
LocalOnlyHotspot.start(onSuccess,onFailure)
//onSuccess we get a jsonobject with ssid and secret
LocalOnlyHotspot.stop(onStop)
//onStop we get a sting 'Stopped'
LocalOnlyHotspot.getConfig(onData)
//onData we get a jsonobject with ssid and secret
```

## Refer to example.js for sample code

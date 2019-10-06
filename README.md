# react-native-local-only-hotspot
This is a react native module to start a local-only hotspot on android devices running android 8 and above
## Getting started

`$ npm install react-native-local-only-hotspot --save`

`
// Following permissions should be added in AndroidManifest.xml <br />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/><br />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/><br />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/><br />
// Location permission should also be taken from user at runtime<br />
`
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

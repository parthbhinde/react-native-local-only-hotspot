# react-native-local-only-hotspot

## Getting started

`$ npm install react-native-local-only-hotspot --save`

### Mostly automatic installation

`$ react-native link react-native-local-only-hotspot`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-local-only-hotspot` and add `LocalOnlyHotspot.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libLocalOnlyHotspot.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.reactlibrary.LocalOnlyHotspotPackage;` to the imports at the top of the file
  - Add `new LocalOnlyHotspotPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-local-only-hotspot'
  	project(':react-native-local-only-hotspot').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-local-only-hotspot/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-local-only-hotspot')
  	```


## Usage
```javascript
import LocalOnlyHotspot from 'react-native-local-only-hotspot';

// TODO: What to do with the module?
LocalOnlyHotspot;
```

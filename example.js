import React, { Component } from 'react'
import { Text, View , TouchableOpacity} from 'react-native'
import LocalOnlyHotspot from 'react-native-local-only-hotspot'
export default class App extends Component {
  constructor(props){
    super(props)
    this.state={
      info:null,
      reason:null
    }
  }
  render() {
    return (
      <View>
        <TouchableOpacity onPress={()=>LocalOnlyHotspot.start(
          (data)=>{
            this.setState({info:data})
          },(reason)=>{
            this.setState({reason:reason})
          })}>
        <Text> Start </Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={()=>LocalOnlyHotspot.stop((data)=>{
        this.setState({reason:data})
        })}>
        <Text> Stop </Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={()=>LocalOnlyHotspot.getConfig((data)=>{
        this.setState({info:data})
      })}>
        <Text> getConfig </Text>
      </TouchableOpacity>
      <Text>{JSON.stringify(this.state.info)}</Text>
      <Text>{JSON.stringify(this.state.reason)}</Text>
      </View>
    )
  }
}


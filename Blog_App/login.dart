import 'package:app_one/MyHomePage.dart';
import 'package:flutter/material.dart';

class LoginPage extends StatelessWidget {
  const LoginPage({ Key? key }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return  Scaffold(
        appBar: AppBar(title: const Text("Home")),
        body: const Body()
    );
  }
}


class Body extends StatefulWidget {
  const Body({ Key? key }) : super(key: key);

  @override
  _BodyState createState() => _BodyState();
}

class _BodyState extends State<Body> {
  String name = '';
  TextEditingController controller = TextEditingController();

  void click(){
    name = controller.text;
    Navigator.push(context, MaterialPageRoute(builder: (context) => MyHomePage(this.name)));
  }

  @override
  Widget build(BuildContext context) {
    return Align(alignment: Alignment.center, 
                child: 
                  Padding(padding: const EdgeInsets.all(10),
                          child: TextField(controller: controller, 
                                            decoration: InputDecoration(
                                                prefixIcon: Icon(Icons.person),
                                                labelText: "Type Your Name:",
                                                border:OutlineInputBorder(borderSide: BorderSide(width: 5, color: Colors.black),),
                                                suffixIcon: IconButton(
                                                  icon: Icon(Icons.check),
                                                  splashColor: Colors.amberAccent,
                                                  tooltip: "Submit",
                                                  onPressed: click,),
                          ))
                        ));
  }
}
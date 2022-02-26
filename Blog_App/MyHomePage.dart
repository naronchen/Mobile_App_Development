import 'package:flutter/material.dart';
import 'post.dart';
import 'postList.dart';
import 'TextInputWidget.dart';
import 'login.dart';




class MyHomePage extends StatefulWidget {
  final String name;
  const MyHomePage(name);
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<Post> posts = [];
  void newPost(String text){
    setState(() {
      posts.add(Post(text, widget.name));
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text("Home")),
        body: Column(children: <Widget>[
          Expanded(child:PostList(posts)), //Expanded to take up the entire screen
          TextInputWidget(newPost),
        ])
    );
  }
}

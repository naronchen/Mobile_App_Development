
import 'package:flutter/material.dart';
import 'post.dart';

class PostList extends StatefulWidget {
  final List<Post> listItems;
  PostList(this.listItems);

  @override
  _PostListState createState() => _PostListState();
}

class _PostListState extends State<PostList> {
  void Like(Function callBack){
    this.setState(() {
      callBack();
    });
  }

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: widget.listItems.length,
      itemBuilder: (context, index){
        var post = widget.listItems[index];
        return Card(
          child:Row(children: <Widget>[
            Expanded(child:ListTile(
              title:Text(post.body),
              subtitle: Text(post.author))),
            Row(children: <Widget>[
              Container(child: Text(post.likes.toString(), style: TextStyle(fontSize:20)),
                padding: EdgeInsets.fromLTRB(0, 0, 10, 0),
              ),
              IconButton(
                icon: const Icon(Icons.thumb_up),
                onPressed: () => Like(post.likePost),
                color: post.liked ? Colors.orangeAccent : Colors.black
                )
              ]
            )
          ]
          )
        );
      },
    );
  }
}



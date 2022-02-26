class Post {
  String body;
  String author;
  int likes = 0;
  bool liked = false;

  Post(this.body, this.author);

  void likePost(){
    liked = !liked;
    if (liked){
      likes += 1;
    }else{
      likes -= 1;
    }

  }
}


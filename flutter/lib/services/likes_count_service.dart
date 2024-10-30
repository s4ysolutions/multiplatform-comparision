import 'dart:async';
import 'dart:math';

class LikesCountService {
  final StreamController<int> _likesController = StreamController<int>.broadcast();
  int _likesCount = 0;

  LikesCountService() {
    _likesCount = Random().nextInt(100);
    _startGeneratingLikes();
  }

  Stream<int> get likesStream => _likesController.stream;

  void dispose() {
    _likesController.close();
  }

  void _startGeneratingLikes() {
    Timer.periodic(const Duration(seconds: 1), (timer) {
      final random = Random();
      _likesCount += random.nextInt(5)>2 ? 1 : -1;
      // Ensure likes don't go below 0
      _likesCount = _likesCount < 0 ? 0 : _likesCount;
      _likesController.add(_likesCount);
    });
  }

}
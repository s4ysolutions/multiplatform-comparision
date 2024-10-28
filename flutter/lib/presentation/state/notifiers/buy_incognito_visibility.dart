import 'package:flutter/cupertino.dart';

class BuyIncognitoVisibility extends ChangeNotifier {
  bool _isVisible = true;

  bool get isVisible => _isVisible;

  void show() {
    _isVisible = true;
    notifyListeners();
  }

  void hide() {
    _isVisible = false;
    notifyListeners();
  }

  void toggle() {
    _isVisible = !_isVisible;
    notifyListeners();
  }
}
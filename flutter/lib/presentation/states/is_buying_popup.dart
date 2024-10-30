import 'package:flutter/widgets.dart';

class IsBuyingPopup extends ChangeNotifier {
  bool _isBuyingPopup = false;

  bool get active => _isBuyingPopup;

  set active(bool value) {
    _isBuyingPopup = value;
    notifyListeners();
  }
}

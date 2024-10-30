import 'dart:async';

import 'package:bloc/bloc.dart';
import 'package:equatable/equatable.dart';
import 'package:puretest/services/likes_count_service.dart';

// Define the states
abstract class LikesCountState extends Equatable {
  @override
  List<Object> get props => [];
}

class LikesCountInitial extends LikesCountState {}

class LikesCountLoaded extends LikesCountState {
  final int likesCount;

  LikesCountLoaded(this.likesCount);

  @override
  List<Object> get props => [likesCount];
}

class LikesCountBloc extends Cubit<LikesCountState> {
  late final StreamSubscription<int> _likesSubscription;

  LikesCountBloc(LikesCountService likesService) : super(LikesCountInitial()) {
    _likesSubscription = likesService.likesStream.listen((likesCount) {
      emit(LikesCountLoaded(likesCount));
    });
  }

  // Optionally, you can have methods for manual control if needed
  void dispose() {
    _likesSubscription.cancel();
    super.close();
  }
}

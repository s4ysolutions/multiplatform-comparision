import 'package:bloc/bloc.dart';
import 'package:equatable/equatable.dart';
import 'package:puretest/services/chat_service.dart';
import 'package:puretest/services/chats_service.dart';

abstract class ChatsState extends Equatable {
  @override
  List<Object> get props => [];
}

class ChatsLoading extends ChatsState {}

class ChatsLoaded extends ChatsState {
  final List<ChatInfoModel> chats;

  ChatsLoaded(this.chats);

  @override
  List<Object> get props => [chats];
}

class ChatsError extends ChatsState {
  final String message;

  ChatsError(this.message);

  @override
  List<Object> get props => [message];
}

class ChatsBloc extends Cubit<ChatsState> {
  final ChatsService _chatsService;

  ChatsBloc(this._chatsService) : super(ChatsLoading()) {
    _loadChats();
  }

  void refresh() {
    _loadChats();
  }

  void _loadChats() async {
    emit(ChatsLoading());
    await Future.delayed(Duration.zero);
    try {
      final chats = await _chatsService.getChats();
      emit(ChatsLoaded(chats));
    } catch (e) {
      emit(ChatsError('Failed to load chats'));
    }
  }
}
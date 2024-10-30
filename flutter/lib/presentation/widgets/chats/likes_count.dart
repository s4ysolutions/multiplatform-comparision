import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:puretest/bloc/likes_count_bloc.dart';

class LikesCount extends StatelessWidget {
  const LikesCount({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<LikesCountBloc, LikesCountState>(
      builder: (context, state) {
        final l10n = AppLocalizations.of(context)!;
        final tt = Theme.of(context).textTheme;
        final count = state is LikesCountLoaded ? state.likesCount : 0;
        final reminder = count % 10;
        final label = reminder == 1
            ? l10n.likesCount1
            : reminder == 2 || reminder == 3 || reminder == 4
                ? l10n.likesCount234
                : l10n.likesCount50;
        return Row(children: [
          CircleAvatar(
            radius: 30,
            backgroundColor: const Color(0xFF1F093A),
            child: SvgPicture.asset(
              'assets/images/chats/heart.svg',
              height: 24,
              width: 24,
            ),
          ),
          SizedBox(width: 16),
          Expanded(
              child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text("$count $label", style: tt.headlineMedium),
            ],
          )),
          Container(
            width: 4,
            height: 4,
            decoration: BoxDecoration(
              color: const Color(0xFFF6F4F4),
              shape: BoxShape.circle,
            ),
          )
        ]);
      },
    );
  }
}

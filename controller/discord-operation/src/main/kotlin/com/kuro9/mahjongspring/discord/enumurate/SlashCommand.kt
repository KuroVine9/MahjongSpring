package com.kuro9.mahjongspring.discord.enumurate

enum class SlashCommand(
    val group: CommandGroup?,
    val period: Period?,
    val crud: Crudable?,
    val pathOfEtc: String?
) {
    PING(null, null, null, "ping"),
    REVALID(null, null, null, "revalid"),
    FILE(null, null, null, "file"),
    MACHI(null, null, null, "machi"),

    STAT_SEASON(CommandGroup.STAT, Period.SEASON, null, null),
    STAT_MONTH(CommandGroup.STAT, Period.MONTH, null, null),
    STAT_ENTIRE(CommandGroup.STAT, Period.ENTIRE, null, null),

    RANK_SEASON(CommandGroup.RANK, Period.SEASON, null, null),
    RANK_MONTH(CommandGroup.RANK, Period.MONTH, null, null),
    RANK_ENTIRE(CommandGroup.RANK, Period.ENTIRE, null, null),

    ADMIN_ADD(CommandGroup.ADMIN, null, Crudable.ADD, null),
    ADMIN_GET(CommandGroup.ADMIN, null, Crudable.GET, null),
    ADMIN_DELETE(CommandGroup.ADMIN, null, Crudable.DELETE, null),

    GAME_GROUP_ADD(CommandGroup.GAME_GROUP, null, Crudable.ADD, null),
    GAME_GROUP_GET(CommandGroup.GAME_GROUP, null, Crudable.GET, null),

    ADD(CommandGroup.SCORE, null, Crudable.ADD, null),
    DELETE(CommandGroup.SCORE, null, Crudable.DELETE, null),
    MODIFY(CommandGroup.SCORE, null, Crudable.MODIFY, null),


    NOT_IMPLEMENT(null, null, null, null);

    companion object {
        private fun toSlashCommand(
            group: CommandGroup?,
            period: Period?,
            crud: Crudable?,
            pathOfEtc: String?
        ) = SlashCommand.entries.find {
            it.group == group &&
                    it.period == period &&
                    it.crud == crud &&
                    it.pathOfEtc == pathOfEtc
        }

        fun toSlashCommand(fullCommand: String): SlashCommand {
            val command = fullCommand.split(" ")

            var group: CommandGroup? = null
            var period: Period? = null
            var crud: Crudable? = null
            var pathOfEtc: String? = null

            when (command.size) {
                1 -> pathOfEtc = command.first()
                2 -> {
                    group = CommandGroup.toCommandGroup(command[0]) ?: return NOT_IMPLEMENT

                    when (group) {
                        CommandGroup.STAT, CommandGroup.RANK ->
                            period =
                                Period.toPeriodEnum(command[1]) ?: return NOT_IMPLEMENT

                        CommandGroup.ADMIN, CommandGroup.GAME_GROUP, CommandGroup.SCORE ->
                            crud = Crudable.toCrudable(command[1]) ?: return NOT_IMPLEMENT
                    }
                }

                else -> return NOT_IMPLEMENT
            }

            return toSlashCommand(group, period, crud, pathOfEtc) ?: throw NotImplementedError("Not support commands")
        }
    }


    enum class CommandGroup(val group: String) {
        STAT("stat"),
        RANK("rank"),
        ADMIN("admin"),
        GAME_GROUP("game_group"),
        SCORE("score");

        companion object {
            fun toCommandGroup(group: String) = CommandGroup.entries.find { it.group == group }
        }
    }

    enum class Period(val path: String) {
        SEASON("season"),
        MONTH("month"),
        ENTIRE("entire");

        companion object {
            fun toPeriodEnum(period: String) = Period.entries.find { it.path == period }
        }
    }

    enum class Crudable(val path: String) {
        ADD("add"),
        GET("get"),
        MODIFY("modify"),
        DELETE("delete");

        companion object {
            fun toCrudable(crud: String) = Crudable.entries.find { it.path == crud }
        }
    }
}
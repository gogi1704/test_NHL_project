package com.example.test_nhl_project.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.test_nhl_project.data.models.myModels.MyInfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

   private val infoData = listOf(
        MyInfoModel("Сколько идет хоккейный матч" , "Хоккейный матч длится 60 минут – три периода по 20 минут, плюс два перерыва по 15 минут. То есть, с учетом перерывов, хоккейный матч идет 90 минут.\n" +
                "\n" +
                "Побеждает команда, забросившая большее количество шайб в ворота противника."),
        MyInfoModel("Овертайм (дополнительное время) в хоккее" , "Назначается в случае, если за основное время команды сыграли вничью. По правилам регулярного чемпионата только один овертайм, играют 3 на 3, длительность – 5 минут. Если за это время шайба так и не была забита, ни в одни ворота — проводится серия буллитов (штрафных бросков).\n" +
                "\n" +
                "Овертаймы в плейофф отличаются, длительность здесь составляет 20 минут, играют 4 на 4, количество неограниченно, игра ведется до первой забитой шайбы."),
        MyInfoModel("Сколько человек в хоккейной команде" , "На поле выходят шесть игроков, один вратарь и пять полевых – 2 защитника и 3 нападающих (форварда). Всего, на матч обычно приходят 20-25 игроков. Замены возможны в любое время, в паузы и непосредственно в игровое время, так же команда может заменить вратаря на еще одного игрока.\n" +
                "\n" +
                "Каждый игрок должен быть соответствующе экипирован, снаряжение хоккеистов состоит из коньков, клюшек, верхней формы и защиты."),
        MyInfoModel("Проброс в хоккее" , "Проброс — это ситуация, когда игрок одной из команд посылает шайбу со своей половины площадки (из-за красной линии), она проходит через всё поле и пересекая линию ворот второй команды, не касаясь ни одного хоккеиста. После проброса ввод шайбы в игру проводится в зоне защиты команды, которая его выполнила."),
        MyInfoModel("Офсайд в хоккее " , "При нарушении правила входа в зону, фиксируется — офсайд (положение вне игры). Назначается, если шайба входит в зону одной из команд, и в этой зоне находится игрок противоположной команды (если оба его конька полностью находятся за линией, определяющей границу зоны).\n" +
                "\n" +
                "Помощник главного арбитра поднимает руку вверх, и если игрок атакующей команды касается шайбы или она направляется в створ ворот, игру останавливают. Назначают вбрасывание в средней зоне. Если касания к шайбе не было, игру продолжают, но положение вне игры продолжается, пока все атакующие игроки не выйдут из зоны соперников или шайба не уйдет из этой зоны. При выполнении любого из условий помощник арбитра должен опустить руку и команды продолжат игру."),
        MyInfoModel("Нарушения в хоккее" , "Нарушениями считаются:\n" +
                "\n" +
                "Толчок на борт (силовой приём)\n" +
                "Удар концом клюшки\n" +
                "Неправильная атака\n" +
                "Атака соперника сзади\n" +
                "Отсечение (силовой приём в манере отсечения или на уровне или ниже уровня колен соперника)\n" +
                "Толчок клюшкой\n" +
                "Удар локтем\n" +
                "Исключительная грубость (действие, не разрешенное правилами, которое приводит или может привести к травме соперника, представителя команды или судьи)\n" +
                "Драки или грубость\n" +
                "Высоко поднятая клюшка\n" +
                "Задержка соперника руками\n" +
                "Задержка руками клюшки соперника\n" +
                "Задержка клюшкой\n" +
                "Атака игрока, не владеющего шайбой (блокировка)\n" +
                "Удар ногой\n" +
                "Нарушение правил с использованием колена\n" +
                "Удар клюшкой\n" +
                "Колющий удар\n" +
                "Подножка\n" +
                "Атака в область головы и шеи\n" +
                "Неспортивное поведение со стороны игроков\n" +
                "Неспортивное поведение со стороны представителей команды\n" +
                "Нарушение численного состава\n" +
                "Умышленный выброс шайбы\n" +
                "Умышленный сдвиг ворот\n" +
                "Нарушение правил экипировки\n" +
                "Умышленная задержка игры\n" +
                "Игра высоко поднятой клюшкой\n" +
                "Пас рукой\n" +
                "Задержка шайбы"),
    )

    val liveDate = MutableLiveData(infoData)
}
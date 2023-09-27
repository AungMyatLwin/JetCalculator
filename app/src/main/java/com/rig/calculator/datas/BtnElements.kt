package com.rig.calculator.datas
class BtnElements {
    companion object{
        var nestedListElements:List<List<String>> = listOf(
            listOf(
                "AC","+/-","%","/"
            )
            ,listOf(
                "7","8","9","*"
            ), listOf(
                "4","5","6","-"
            ),
            listOf(
                "1","2","3","+"
            ),
            listOf(
                "0",".","="
            )
        )
        var compareList:List<String> = listOf("/","*","-","+","=")

        var operators:List<String> = listOf("/","*","-","+","=","%","AC","+/-")
    }
}
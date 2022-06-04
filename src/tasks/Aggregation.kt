package tasks

import contributors.User

/*
TODO: Write aggregation code.

 In the initial list each user is present several times, once for each
 repository he or she contributed to.
 Merge duplications: each user should be present only once in the resulting list
 with the total value of contributions for all the repositories.
 Users should be sorted in a descending order by their contributions.

 The corresponding test can be found in test/tasks/AggregationKtTest.kt.
 You can use 'Navigate | Test' menu action (note the shortcut) to navigate to the test.
*/

fun doGroup(arg: List<User>): List<User> =
    arg.groupBy { it.login }
        .map { (login, contribList) -> User(login, contribList.sumOf { it.contributions }) }
        .sortedByDescending { it.contributions }

fun doGroupingBy(arg: List<User>): List<User> =
    arg.groupingBy { it.login }
        .fold(0) { acc, (_, contribCount) -> acc + contribCount }
        .map { (login, contribList) -> User(login, contribList) }
        .sortedByDescending { it.contributions }
fun List<User>.aggregate(): List<User> = doGroup(this)
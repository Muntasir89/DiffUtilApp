# DiffUtilApp
It is a Utility class that can calculate the difference betweeen two lists and output a list of updated operations that converts the first list into the second one.</br>
When we build a recyclerView adapter and we want to update in the list, we usually use **_notifyDataSetChanged()_**. But it updates all views in the list even though we want to update a single list.</br>
For this solution **_DiffUtil_** comes in. It is based on **Eugene W.Myers's difference Algorithm**. 
### Working Procsss
It takes two list **OldList** and **NewList**. It will update those lists that had been changed. 
### DiffUtil class
```kotlin
class MyDiffUitl(
    private val oldList: List<Person>,
    private val newList: List<Person>,
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {false}
            oldList[oldItemPosition].name != newList[newItemPosition].name -> {false}
            oldList[oldItemPosition].age != newList[newItemPosition].age -> {false}
            else -> true
        }
    }
}
```
### Output
![Output](https://user-images.githubusercontent.com/78687005/201879423-565a7d52-1ada-4eb5-9212-665bc5a05c40.gif)

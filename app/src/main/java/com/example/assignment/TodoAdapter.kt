package com.example.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.assignment.database.Todo
import com.example.assignment.database.TodoRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoAdapter(items:List<Todo>, repository: TodoRepository,viewModel:MainActivityData):Adapter<TodoViewHolder>(){


    var context:Context? = null
    val items = items
    val repository = repository
    val viewModel = viewModel
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.vew_item,parent,false)
       context=parent.context
        return TodoViewHolder(view)

    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
    holder.cbTodo.text= items.get(position).item
   holder.ivDelete.setOnClickListener {
       val isChecked = holder.cbTodo.isChecked

if(isChecked){
    CoroutineScope(Dispatchers.IO).launch { repository.delete(items.get(position))
        val data = repository.getAllTodoItems()
    withContext(Dispatchers.Main){
       viewModel.setData(data)
    }
    }

}
       else{
           Toast.makeText(context,"Select the items to be deleated",Toast.LENGTH_LONG).show()

       }

   }
    }


}
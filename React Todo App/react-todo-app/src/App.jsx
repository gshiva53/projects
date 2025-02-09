import { useState } from "react";

const initialTodoList = [
  { id: 0, name: "Sample task name 01", isComplete: false },
  { id: 1, name: "Sample task name 02", isComplete: true },
  { id: 2, name: "Sample task name 03", isComplete: true },
];

export default function TodoApp() {
  const [todoList, setTodoList] = useState(initialTodoList);
  const [newTaskName, setNewTaskName] = useState("");
  const nextTaskId = todoList.length;

  function handleAddTaskToTodoList() {
    const newTodoList = [
      ...todoList,
      {
        id: nextTaskId,
        name: newTaskName,
        isComplete: false,
      },
    ];

    setTodoList(newTodoList);
    setNewTaskName("");
  }

  function handleTaskCompletion(completedTaskId) {
    const newTodoList = todoList.map((task) => {
      if (task.id === completedTaskId) {
        return {
          ...task,
          isComplete: !task.isComplete,
        };
      } else {
        return task;
      }
    });

    setTodoList(newTodoList);
  }

  function handleTaskNameChange(e, changeNameTaskId) {
    // alert("Task name change inside the Todo App works");

    const newTodoList = todoList.map((task) => {
      if (task.id === changeNameTaskId) {
        return {
          ...task,
          name: e.target.value,
        };
      } else {
        return task;
      }
    });

    setTodoList(newTodoList);
  }

  return (
    <div className='grid grid-cols-1 justify-items-center'>
      <h1 className='text-5xl p-2 mt-5 mb-5'>Simple Todo Application</h1>
      <form
        onSubmit={(e) => {
          e.preventDefault();
        }}
      >
        <input
          type='text'
          className='bg-stone-100 w-xs shadow-md pl-2'
          onChange={(e) => setNewTaskName(e.target.value)}
          value={newTaskName}
        />
        <button
          className='bg-stone-100 w-16 m-2 mt-5 rounded-md border border-slate-500'
          onClick={handleAddTaskToTodoList}
        >
          ADD
        </button>
      </form>
      <TodoList
        todoList={todoList}
        onTaskCompletion={handleTaskCompletion}
        onTaskNameChange={handleTaskNameChange}
      />
    </div>
  );
}

function TodoList({ todoList, onTaskCompletion, onTaskNameChange }) {
  const taskIncompleteStyle = "text-base";
  const taskCompleteStyle = taskIncompleteStyle + " line-through";

  const listItems = todoList.map((task) => (
    <li key={task.id}>
      <div>
        <input
          type='checkbox'
          className='p-2 m-2'
          onChange={() => {
            onTaskCompletion(task.id);
          }}
          checked={task.isComplete}
        />
        <input
          className={task.isComplete ? taskCompleteStyle : taskIncompleteStyle}
          type='text'
          value={task.name}
          onChange={(e) => {
            onTaskNameChange(e, task.id);
          }}
        />
      </div>
    </li>
  ));

  return (
    <div>
      <ul>{listItems}</ul>
    </div>
  );
}

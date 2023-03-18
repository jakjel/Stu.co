import React from "react";

export default function SearchBar(props) {
  return (
    <div>
      <form className="serach-container">
      <input onChange={props.textChanged} className="search_bubble" type="text" placeholder={props.text}>
      </input>
      </form>
    </div>
  )
}
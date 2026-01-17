import React, { useState } from "react";

function TransactionForm() {
  const [categorySelected, setCategorySelected] = useState("");
  const [description, setDescription] = useState("");

  const handleCategoryChange = (event) => {
    setCategorySelected(event.target.value);
  };

  const handleDescriptionChange = (e) => {
    setDescription(e.target.value);
  };

  return (
    <div className="container min-vh-100 d-flex justify-content-center align-items-center">
      <form className="w-100" style={{ maxWidth: "500px" }}>
        <div className="mb-3">
          <label htmlFor="category" className="form-label">
            CATEGORY
          </label>
          <select
            id="category"
            value={categorySelected}
            onChange={handleCategoryChange}
            className="form-select"
          >
            <option value="Income">Income</option>
            <option value="Expense">Expense</option>
          </select>
        </div>

        <div className="mb-3">
          <label htmlFor="amount" className="form-label">
            AMOUNT
          </label>
          <input
            input="number"
            id="amount"
            placeholder="0.00"
            class="form-control"
          ></input>
        </div>

        <label className="form-label">CATEGORY</label>

        {categorySelected === "Income" && (
          <select className="form-select">
            <option>Salary</option>
            <option>Gift</option>
            <option>Other</option>
          </select>
        )}

        {categorySelected === "Expense" && (
          <select className="form-select">
            <option>Home</option>
            <option>Food</option>
            <option>Transport</option>
            <option>Health</option>
            <option>Entertainment</option>
            <option>Hobbies</option>
          </select>
        )}

        {!categorySelected && (
          <select className="form-select">
            <option>Select a category first</option>
          </select>
        )}

        <div className="mb-3">
          <label htmlFor="description" className="form-label">
            DESCRIPTION
          </label>

          <textarea
            className="form-control"
            id="description"
            placeholder="What was this for?"
            value={description}
            onChange={handleDescriptionChange}
            rows="3"
          />
        </div>

        <div className="d-grid gap-2">
          <button type="submit" className="btn btn-primary mb-3">
            Save this transaction
          </button>

          <button className="btn btn-secondary mb-3">Cancel</button>
        </div>
      </form>
    </div>
  );
}

export default TransactionForm;

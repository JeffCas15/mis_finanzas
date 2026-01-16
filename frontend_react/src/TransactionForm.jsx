import React, { useState } from 'react';

function TransactionForm(){

    const [categorySelected, setCategorySelected] = useState('');
    const [description, setDescription] = useState('');

    const handleCategoryChange = (event) => {
    setCategorySelected(event.target.value);
    };

    const handleDescriptionChange = (e) =>{
        setDescription(e.target.value);
    }

    return(
        <form>
            <select id="category" value={categorySelected} onChange={handleCategoryChange}>
                <option value= "Income">Income</option>
                <option value="Expense">Expense</option>
            </select>

            <label htmlFor="amount">AMOUNT</label>
            <input input="number" id="amount" placeholder='0.00'></input>

            <label>CATEGORY</label>

            {categorySelected === 'Income' && (
            
            <select>
                <option>Salary</option>
                <option>Gift</option>
                <option>Other</option>
          </select>
       
            )}

            {categorySelected === 'Expense' && (
            
            <select>
                <option>Home</option>
                <option>Food</option>
                <option>Transport</option>
                <option>Health</option>
                <option>Entertainment</option>
                <option>Hobbies</option>
          </select>
       
            )}

            {!categorySelected && (
                <select>
                    <option>Select a category first</option>
                </select>
            )}

            <label htmlFor="description">DESCRIPTION</label>
            
            <input 
                type="text" 
                id="description" 
                placeholder='What was this for?' 
                value={description}
                onChange={handleDescriptionChange}
            />
            

            <button type='submit'>Save this transaction</button>
            <button>Cancel</button>
           
        </form>
    );
}

export default TransactionForm;
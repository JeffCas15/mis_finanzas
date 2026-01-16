import TransactionRow from './TransactionRow';


function App(){
  return(
    <table>
      <thead>
        <tr>
          <th>Type</th>
          <th>Amount</th>
          <th>Description</th>
        </tr>
      </thead>
      <tbody>
        <TransactionRow 
          type = "income"
          amount = {25000}
          description = "Mom's gift" />

        <TransactionRow
          type = "expense"
          amount = {10000}
          description = "Taxi to Mom's house" />
        
      </tbody>
    </table>
  );
}

export default App

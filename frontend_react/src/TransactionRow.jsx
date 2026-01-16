function TransactionRow(props){

  return(
    <tr>
        <td>{props.type}</td>
        <td style={{ color: props.type === "income" ? "green" : "red" }}>{props.amount}</td>
        <td>{props.description}</td>
    </tr>
  );
  
}

export default TransactionRow;
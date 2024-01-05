window.addEventListener('load', () => {

    //call table refresh function
    refreshEmployeeTable();
    //call form refreash function
    // refreshEmployeeForm()
})

//create function for refreash table record
const refreshEmployeeTable = () => {
  
    employees = ajaxGetRequest('/employee/findall')


    const displayProperty = [
        { property: 'empno', dataType: 'string' },
        { property: 'fullname', dataType: 'string' },
        { property: 'nic', dataType: 'string' },
        { property: 'mobile', dataType: 'string' },
        { property: 'email', dataType: 'string' },
        // { property: 'dob', dataType: 'string' },
        // {property:'employeeStatus_id.name',dataType:'object'},
        { property: getEmployeeStatus, dataType: 'function' },
        { property: getEmpDesign, dataType: 'function' },
        { property: getHasUserAccount, dataType: 'function' },
        // { property: "hasUserAccount", dataType: 'boolean' },

    ]

    //call fill data into table function
    // fillDataIntoTable(tableId,dataList, display property List, refillFunctionName, deleteFunctionName, printFunctionName,buttonVisibility)
    fillDataIntoTable(tableEmployee, employees, displayProperty, refillEmployeeForm, deleteButtonFunction, printEmployee, true)
    // Initialize DataTables on the tableEmployee
    $(document).ready(function () {
        $('#tableEmployee').DataTable({
            paging: true, // Enable pagination
            searching: true, // Enable search
        });
    });


}
const refillEmployeeForm =()=>{
    console.log("Re Fill");
}
const deleteButtonFunction = ()=>{
    console.log("Delete ");
}
const printEmployee = ()=>{
    console.log("Print");
}
const getEmployeeStatus = (rowOb) => {

    if (rowOb.employeestatus_id.name == 'Working') {

        return '<p class="working-status">' + rowOb.employeestatus_id.name + '</p>';
    }
    if (rowOb.employeestatus_id.name == 'Resign') {

        return '<p class="resign-status">' + rowOb.employeestatus_id.name + '</p>';
    }
    if (rowOb.employeestatus_id.name == 'Deleted') {

        return '<p class="deleted-status">' + rowOb.employeestatus_id.name + '</p>';
    }
}

const getEmpDesign = (rowOb) => {
    if (rowOb.designation_id.name == 'Manager') {
        return '<p class="working-status">' + rowOb.designation_id.name + '</p>';
    }
    if (rowOb.designation_id.name == 'Store-Manager') {
        return '<p class="resign-status">' + rowOb.designation_id.name + '</p>';
    }
    if (rowOb.designation_id.name == 'Cashier') {
        return '<p class="deleted-status">' + rowOb.designation_id.name + '</p>';
    }
}


const getHasUserAccount = (rowOb) => {
    // console.log(rowOb);
    // hasUserAccount = ajaxGetRequest("/employee/listwithoutuseraccount")
    // console.log("hasUserAccount names=======>", hasUserAccount);
    // console.log("rowOb", rowOb);
    // for (let element of hasUserAccount) {
    //     console.log(element.fullname);
        
    //     if (element.fullname === rowOb.fullname) {
    //         return '<p class="working-status">' + 'yes' + '</p>';
    //     }
     
    // }

}
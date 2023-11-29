import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { question } from 'ngx-bootstrap-icons';
import { Subject } from 'rxjs';
import { DashboardService } from '../dashboard.service';
import { Details } from '../model/Details';
import { Product } from '../model/Product';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-show-all-products',
  templateUrl: './show-all-questions.component.html',
  styleUrls: ['./show-all-questions.component.css']
})
export class ShowAllQuestionsComponent implements OnInit {
 productList:Array<Product>=[]
 id:any;
 userName:string="";
 product:Product={
   productCode: "",
   brand: "",
   price: "",
   userName: "",
   date: "",
   imagelink: "",
   description: undefined
 }
  dashboardService: any;

  constructor(private service:DashboardService,private router:Router,private registrationService:RegistrationService,private route:ActivatedRoute) { }

  ngOnInit(): void {

    this.id=this.route.snapshot.paramMap.get('userName');
    if(this.registrationService.getloginUserName()!=null){
      this.userName=this.registrationService.getloginUserName()
    }
    this.allQuestions(this.userName);
    this.getProduct(this.userName);
  }
  
  //This method is used to get all Questions of product
  allQuestions(userName:any){
    this.service.getQuestionsByUserName(userName).subscribe((data)=>{
    this.productList=data;
     },
     (error)=>
     console.log(error))
  }
  //This method is used to get product 
 getProduct(userName:any){
  this.service.getProductById(userName).subscribe((data)=>{
  this.product=data;
  },(error)=>{
  console.log(error)
})

 }

 //For Logout
 logOutLogin() {

  if(confirm("Are you sure to Logout ?")) { 
    this.registrationService.logOut();
    // location.reload();
     this.router.navigate(['/home']);
 }
 
}



sort(event: any) {
  switch (event.target.value) {
    case "Low":
      {
        this.productList = this.productList.sort((low, high) => low.price - high.price);
        break;
      }

    case "High":
      {
        this.productList = this.productList.sort((low, high) => high.price - low.price);
        break;
      }

    case "Brand":
      {
        this.productList = this.productList.sort(function (low, high) {
          if (low.brand > high.brand) {
            return -1;
          }
          else if (low.brand < high.brand) {
            return 1;
          }
          else {
            return 0;
          }
        })
        break;
      }

  }
  return this.productList;
}

}

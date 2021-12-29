import { Router } from '@angular/router';
import { ComponentscontrollerService } from './../componentscontroller.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup ,FormBuilder, Validators, FormGroupName} from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private formB:FormBuilder,private controller:ComponentscontrollerService, private route:Router) {
this.loginForm=this.formB.group({ login:this.formB.group({
  Name:['',[Validators.required]],
  UserName:['',[Validators.required]],
  Password:['',[Validators.required,Validators.minLength(4)]],
  DateOfBirth:['',[Validators.required]]})})




  }
  public loginForm: FormGroup ;

  ngOnInit() {

  }
  check(){
    if(this.loginForm.invalid){return;}else{
    let form=this.loginForm.get(['login'])?.value;
   return this.controller.checklogin(form.UserName,form.Password)}

  }

  onSubmit(){
    if(this.loginForm.invalid ){return;}else{
      console.log(this.check())
      if(!this.check()){
    let form=this.loginForm.get(['login'])?.value;

   console.log( this.controller.makelogin(form));
   this.route.navigateByUrl(`/register`);}

  }


  }


}

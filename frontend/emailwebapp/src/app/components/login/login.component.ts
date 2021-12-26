import { ComponentscontrollerService } from './../componentscontroller.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup ,FormBuilder, Validators, FormGroupName} from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private formB:FormBuilder,private controller:ComponentscontrollerService) {
this.loginForm=this.formB.group({ login:this.formB.group({
  username:['',[Validators.required]],
  password:['',[Validators.required]],
  name:['',[Validators.required]],
  birthday:['',[Validators.required]]})})




  }
  public loginForm: FormGroup ;

  ngOnInit() {

  }
  check(){
    let form=this.loginForm.get(['login'])?.value;
   return this.controller.checklogin(form.username,form.password)

  }
  onSubmit(){
    let form=this.loginForm.get(['login'])?.value;
    console.log(form.username)
    console.log(form.password)
    console.log(form.birthday)
    this.controller.makelogin(form);


  }


}

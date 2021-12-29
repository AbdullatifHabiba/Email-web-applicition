import { Router } from '@angular/router';
import { ComponentscontrollerService } from './../componentscontroller.service';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private frb:FormBuilder,private controller:ComponentscontrollerService,private route:Router) {
    this.registerform=frb.group({ register:this.frb.group({
      username:['',[Validators.required]],
      password:['',[Validators.required]],


    })})
   }

  ngOnInit(): void {
  }
registerform:FormGroup;
check(){
  let f=this.registerform.get(['register'])?.value;
 return this.controller.checklogin(f.username,f.password)
}
onSubmit(){
  if(this.registerform.invalid){return;}
if(this.registerform.valid){
  let f=this.registerform.get(['register'])?.value;
  //console.log(this.check())

if ( this.check()) {
  //console.log(this.check())

  this.route.navigateByUrl(`/header/${f.username}`);
}
}
      }
}

import { Component, OnInit } from '@angular/core';
import {AfterViewInit, ViewChild} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { ComponentscontrollerService } from '../componentscontroller.service';

@Component({
  selector: 'app-Contact',
  templateUrl: './Contact.component.html',
  styleUrls: ['./Contact.component.css']
})

export class ContactComponent implements OnInit {


constructor(private FB:FormBuilder,private controller:ComponentscontrollerService){
  this.contact=FB.group({ contact:this.FB.group({
    Name:['',[Validators.required]],
    usernames:['',],


  })})
}
addone :boolean=false;
Users:user[]=[];
add(){
  this.addone=true
}
  ngOnInit(): void {
  }
  contact:FormGroup;
adduser(){
  let f=this.contact.get(['contact'])?.value;
  let user:user={name:f.Name,usernames:f.usernames}
  this.Users.push(user);
}
Delete(i:number){
  this.Users=this.Users.slice(1,i+1)
  this.controller.delete(i,"Contact");
}
edit(i:number){
this.Delete(i);
this.add();
}

}



  export interface user {
    name: string;
    usernames:string[];
  }


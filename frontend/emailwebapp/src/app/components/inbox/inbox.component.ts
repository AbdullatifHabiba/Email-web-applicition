import { FormGroup } from '@angular/forms';
import { Email } from './../Email';
import { Component, OnInit, Output } from '@angular/core';
import { ComponentscontrollerService } from '../componentscontroller.service';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit  {

list:any=[
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},


]
page:number=1;
size:number=5;
elenum:number=this.list.length;

constructor(private controll:ComponentscontrollerService) { }

ngOnInit(): void {}
InboxEmails:Array<Email>=[];
getinbox(){
this.InboxEmails=this.controll.InboxEmails;
}
clippage(){}
}






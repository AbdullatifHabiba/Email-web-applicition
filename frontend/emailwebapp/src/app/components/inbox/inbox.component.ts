import { EmailDetialsComponent } from './../EmailDetials/EmailDetials.component';
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
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"nnnn",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmcvcvved",body:"helvvvlo",Subject:"jhjhh"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmmed",body:"hvvvello",Subject:"nvnbb"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmeed",body:"hello",Subject:"Yourmnmhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmeeeed",body:"hellvvvo",Subject:"nbnnn"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Adshmed",body:"helhhhlo",Subject:"mmmnnmm"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmeeed",body:"hellhjjjo",Subject:"Yourmjmnmmhealth"},


]
page:number=1;
size:number=5;
elenum:number=this.list.length;

constructor(private controll:ComponentscontrollerService,) { }

ngOnInit(): void {}
InboxEmails:Array<Email>=[];
getinbox(){
this.InboxEmails=this.controll.InboxEmails;
}
clippage(){}

getemail(id:number){
this.controll.getemaildetails(id);
}
addimportant(id:number){}
addstar(id:number){}
addspam(id:number){}
deletem(id:number){}

}




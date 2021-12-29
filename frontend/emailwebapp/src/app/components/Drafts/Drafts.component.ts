import { Component, OnInit } from '@angular/core';
import { ComponentscontrollerService } from '../componentscontroller.service';
import { Email } from '../Email';

@Component({
  selector: 'app-Drafts',
  templateUrl: './Drafts.component.html',
  styleUrls: ['./Drafts.component.css']
})
export class DraftsComponent implements OnInit {




  ngOnInit() {

  }


  Draftitems=[
 /* {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
  {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"hello",Subject:"Yourhealth"},
*/

]
page:number=1;
size:number=5;
elenum:number;
DraftEmails:Email[];

constructor(private controll:ComponentscontrollerService) {
  this.DraftEmails=this.controll.draftEmails;
this.elenum=this.DraftEmails.length
  console.log(this.DraftEmails)
}

getDraftEmails(){
}
clippage(){}
}


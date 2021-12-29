import { Component, OnInit } from '@angular/core';
import { ComponentscontrollerService } from '../componentscontroller.service';
import { Email } from '../Email';

@Component({
  selector: 'app-Trash',
  templateUrl: './Trash.component.html',
  styleUrls: ['./Trash.component.css']
})
export class TrashComponent implements OnInit {

  Trashemails:Email[];

  page:number=1;

  size:number=5;
  elenum:number;

  constructor(private controll:ComponentscontrollerService) {
    this.Trashemails=this.controll.draftEmails;
  this.elenum=this.Trashemails.length
    console.log(this.Trashemails)
  }
  list=[
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"nnnn",Subject:"Yourhealth"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmcvcvved",body:"helvvvlo",Subject:"jhjhh"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmmed",body:"hvvvello",Subject:"nvnbb"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmeed",body:"hello",Subject:"Yourmnmhealth"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmeeeed",body:"hellvvvo",Subject:"nbnnn"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Adshmed",body:"helhhhlo",Subject:"mmmnnmm"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmeeed",body:"hellhjjjo",Subject:"Yourmjmnmmhealth"},


  ]
  getTrashemailsEmails(){
  }
  clippage(){}

  ngOnInit() {
  }

}

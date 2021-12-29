import { Component, OnInit } from '@angular/core';
import { ComponentscontrollerService } from '../componentscontroller.service';
import { Email } from '../Email';

@Component({
  selector: 'app-SentItems',
  templateUrl: './SentItems.component.html',
  styleUrls: ['./SentItems.component.css']
})
export class SentItemsComponent implements OnInit {


  ngOnInit() {
  }
  Sentemails:Email[];

  page:number=1;

  size:number=5;
  elenum:number;

  constructor(private controll:ComponentscontrollerService) {
    this.Sentemails=this.controll.draftEmails;
  this.elenum=this.Sentemails.length
    console.log(this.Sentemails)
  }
  list:any=[
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmed",body:"nnnn",Subject:"Yourhealth"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmcvcvved",body:"helvvvlo",Subject:"jhjhh"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmmed",body:"hvvvello",Subject:"nvnbb"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmeed",body:"hello",Subject:"Yourmnmhealth"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmeeeed",body:"hellvvvo",Subject:"nbnnn"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Adshmed",body:"helhhhlo",Subject:"mmmnnmm"},
    {name:"Ahmed",time:"5:54Am",to:"ali",from:"Ahmeeed",body:"hellhjjjo",Subject:"Yourmjmnmmhealth"},


  ]
  getDraftEmails(){
  }
  clippage(){}
  }


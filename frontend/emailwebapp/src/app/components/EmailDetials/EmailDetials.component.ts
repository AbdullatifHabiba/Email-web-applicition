import { ComponentscontrollerService } from './../componentscontroller.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Email } from '../Email';

@Component({
  selector: 'app-EmailDetials',
  templateUrl: './EmailDetials.component.html',
  styleUrls: ['./EmailDetials.component.css']
})
export class EmailDetialsComponent implements OnInit {
  public email?: Email;
  public form?: FormGroup;
  public reply = false;
  arrr=[]
  constructor(
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,
    private route: Router,


  ) {
    //this.email=  {page:"1",time:"5:54Am",to:"ali",from:"Ahmed",body:"<p>hello</p>",Subject:"Yourhealth"}

    console.log(this.activatedRoute.snapshot.data)

    this.activatedRoute.data.subscribe(({ email }) => {  this.email = email });
  }

  public ngOnInit(): void {

  }

  public onReply(): void {
    this.reply  = !this.reply;
  }

  public onSubmit(): void {}
    //console.log(this.form.getRawValue());
    //this.emailService.sendEmail(this.form.getRawValue()).subscribe(() => {
      //this.reply = false;
   // });


  /*private buildForm(): void {
    this.form = this.formBuilder.group( {
      to: [{ value: this.email.from, disabled: true, },
        Validators.required,
        Validators.email],
      subject: ['', [
        Validators.required,
        Validators.maxLength(20)]],
      text: ['', [Validators.required]]
    });
  }*/
}

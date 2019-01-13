import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DadComponentComponent } from './dad-component.component';

describe('DadComponentComponent', () => {
  let component: DadComponentComponent;
  let fixture: ComponentFixture<DadComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DadComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DadComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

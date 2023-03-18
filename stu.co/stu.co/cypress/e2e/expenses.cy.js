describe('Login and see users expenses', () => {
    it('See ', function () {
      cy.visit('http://localhost:3000')
      
      cy.contains('Sign in').click()
      
      cy.get('input[name=username]').type("daniil")
  
      cy.get('input[name=password]').type("test123")
      cy.contains('Sign in').click()
  
      cy.url().should('include', '/feed')
      cy.visit('http://localhost:3000/expenses')
      cy.contains('Trio-Mio').click()
      cy.get('#0').click()
      cy.get('#1').click()
      cy.get('#1').should('contain', 'jakjel')
    })
  })
describe('The Login Page', () => {
  it('login', function () {
    cy.visit('http://localhost:3000')
    
    cy.contains('Sign in').click()
    
    cy.get('input[name=username]').type("daniil")

    // {enter} causes the form to submit
    cy.get('input[name=password]').type("test123")
    cy.contains('Sign in').click()

    // we should be redirected to /feed
    cy.url().should('include', '/feed')
  })
})
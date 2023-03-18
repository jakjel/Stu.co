describe('Create user', () => {
    it('creates user', function () {
        cy.visit('http://localhost:3000')

        cy.contains('Join us by creating new account here...').click()

        cy.get('input[name=email]').type("test@gmail.com")

        cy.get('input[name=first_name]').type("Test")

        cy.get('input[name=last_name]').type("Testovksi")

        cy.get('input[name=username]').type("test")

        cy.get('input[name=password]').type("test123")
        cy.contains('Sign up').click()
        cy.on('window:alert', (str) => {
            expect(str).to.equal(`Account created`)
        })
    })
})
